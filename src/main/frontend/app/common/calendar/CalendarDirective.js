angular.module('MyBeerApp')
  .directive('calendar', function(CalendarFactory) {
    return {
      restrict: 'E',
      templateUrl: 'app/common/calendar/calendar.tmpl.html',
      scope: {
        current: '=current',
        events: '=events'
      },
      link: function(scope) {
        scope.current = _removeTime(scope.current || moment());
        scope.month   = scope.current.clone();
        
        var startDate = scope.current.clone();
        startDate.date(1);
        _removeTime(startDate.day(0));

        _getRangedEvents(2014, scope.month.month(), scope);
        _buildMonth(scope, startDate, scope.month);

        /* re-build the month when the events json get request finishes.. */
        scope.$watch('events', function(newValue, oldValue) {
          _buildMonth(scope, startDate, scope.month);
        });

        scope.next = function() {
          var next = scope.month.clone();
          _removeTime(next.month(next.month() + 1).date(1));
          scope.month.month(scope.month.month() + 1);
          
          _getRangedEvents(2014, scope.month.month(), scope);
          _buildMonth(scope, next, scope.month);

          console.log('Next Month');
        };

        scope.previous = function() {
          var previous = scope.month.clone();
          _removeTime(previous.month(previous.month() - 1).date(1));
          scope.month.month(scope.month.month() - 1);
          
          _getRangedEvents(2014, scope.month.month(), scope);
          _buildMonth(scope, previous, scope.month);

          console.log('Previous Month');
        };
        
        scope.viewEvents = function(day) {
          scope.currentDay = day;
          scope.dialogVisible = true;
        };
      }
    };

    function _removeTime(date) {
      return date.day(0).hour(0).minute(0).second(0).millisecond(0);
    }

    function _buildMonth(scope, startDate, month) {
      scope.weeks = [];
      var done = false,
          date = startDate.clone(),
          monthIndex = date.month(),
          count = 0;
      while(!done) {
        scope.weeks.push({ 
          days: _buildWeek(scope, date.clone(), month)
        });

        date.add(1, 'w');
        done = count++ > 2 && monthIndex !== date.month();
        monthIndex = date.month();
      }
    }

    function _buildWeek(scope, date, month) {
      var days = [];
      for(var i = 0; i < 7; i++) {
        days.push({
          dayOfWeek: date.format('ddd'),
          number: date.date(),
          isCurrentMonth: date.month() === month.month(),
          isToday: date.isSame(new Date(), 'day'),
          date: date,
          events: _getEvents(scope, date)
        });
        
        date = date.clone();
        date.add(1, 'd');
      }
      return days;
    }

    function _getEvents(scope, date) {
      var events = [];
      
      if(scope.events != null && scope.events != undefined && scope.events[0] != undefined && date.date() >= new Date(scope.events[0].eventDate).getDate()) {
        for(var i = 0; i < scope.events.length; i++) {
          var event = scope.events[i];
          var eventDate = new Date(event.eventDate);
          
          if(date.isSame(eventDate, 'day')) {
            events.push(event);
          }
        }
      }
      return events;
    }
    
    function _getRangedEvents(year, month, scope) {
      CalendarFactory.getRangedEvents(year, month).success(function(data, code) {
        console.log('The request was successful!', code, data);
        
        scope.events = data;
      });
    }
  });
