/**
 * Adds a dropdown menu item that allows for keyboard accessibility
 *
 * @prop action the function to call when the item is clicked (normally should close the menu)
 * @prop tabIndex the tabindex of the menu item (defaults to 0)
 * @children the content to render in the menu item
 */
var DropdownMenuItem = React.createClass({
  propTypes: {
    action: React.PropTypes.func.isRequired,
    tabIndex: React.PropTypes.number,
    component: React.PropTypes.oneOf(['button', 'a'])
  },

  getDefaultProps: function() {
    return {
      tabIndex: 0,
      component: 'button'
    };
  },

  handleKeyDown: function(e) {
    var key = e.which || e.keyCode;
    if(key === 32) { // spacebar
      e.preventDefault(); // prevent page scrolling
      this.props.action();
    }
  },
  
  render: function() {
    var children = React.createElement(this.props.component, { onClick: this.props.action }, this.props.children);
    return (
      <li>
        {children}
      </li>
    );
  }
});

module.exports = DropdownMenuItem;
