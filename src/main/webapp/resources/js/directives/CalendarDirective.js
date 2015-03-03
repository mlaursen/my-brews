angular.module('MyBeerApp')
  .directive('calendar', function() {
    return {
      restrict: 'E',
      templateUrl: 'templates/calendar.html',
      scope: {
        current: '='
      },
      link: function(scope) {
        scope.current = _removeTime(scope.current || moment());
        scope.month   = scope.current.clone();
        
        var startDate = scope.current.clone();
        startDate.date(1);
        _removeTime(startDate.day(0));

        _buildMonth(scope, startDate, scope.month);


        scope.select = function(day) {
          scope.current = day.date;
          console.log('Selected ' + day);
        }

        scope.next = function() {
          var next = scope.month.clone();
          _removeTime(next.month(next.month() + 1).date(1));
          scope.month.month(scope.month.month() + 1);

          _buildMonth(scope, next, scope.month);

          console.log('Next Month');
        }

        scope.previous = function() {
          var previous = scope.month.clone();
          _removeTime(previous.month(previous.month() - 1).date(1));
          scope.month.month(scope.month.month() - 1);

          _buildMonth(scope, previous, scope.month);

          console.log('Previous Month');
        }
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
          days: _buildWeek(date.clone(), month)
        });

        date.add(1, 'w');
        done = count++ > 2 && monthIndex !== date.month();
        monthIndex = date.month();
      }
    }

    function _buildWeek(date, month) {
      var days = [];
      for(var i = 0; i < 7; i++) {
        days.push({
          dayOfWeek: date.format('ddd'),
          number: date.date(),
          isCurrentMonth: date.month() === month.month(),
          isToday: date.isSame(new Date(), 'day'),
          date: date
        });
        
        date = date.clone();
        date.add(1, 'd');
      }
      return days;
    }
  });
