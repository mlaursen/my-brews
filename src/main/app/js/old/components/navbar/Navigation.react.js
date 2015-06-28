var React = require('react');

var Navigation = React.createClass({
  render: function() {
    return (
      <nav>
        <RedirectButton icon='beer' page='beer' text='Beers' />
        <RedirectButton icon='calendar' page='calendar' text='Calendar' />
      </nav>
    );
  }
});

module.exports = Navigation;

var RedirectButton = React.createClass({
  render: function() {
    return (
      <button type="button" className="btn-icon-text" onclick={"location.href='" + this.props.page + ".html'"}>
        <span className={'fa fa-' + this.props.icon}></span>
        <span>{this.props.text}</span>
      </button>
    );
  }
});
