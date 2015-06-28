var HamburgerButton = require('./HamburgerButton.react');
var DropdownMenu = require('./DropdownMenu.react');


/**
 * Creates a hamburger menu with a neat animation when clicked.
 *
 * Use the Openable.react.js component wrapper to get the fucntions for toggling
 * the open state of this component. They are not included in this component itself
 * so that the menu items are able to close the menu when they are clicked.
 *
 * @prop isOpen boolean if the hamburger menu is open
 * @prop toggleOpen the function to toggle the open state
 * @prop close the function to close the menu with
 * @prop label the aria label and the help text value
 * @prop helpPosition the position of the help text dropdown
 * @prop isLarge boolean if this is the large version of the hamburger menu
 * @prop menuClasses an array of additional css classes to apply to the dropdown menu
 * @prop onOpenFunc an optional function to call when opening the hamburger menu
 * @prop onCloseFunc an optional funciton to call when closing the hamburger menu
 */
var HamburgerMenu = React.createClass({
  propTypes: {
    isOpen: React.PropTypes.bool.isRequired,
    toggleOpen: React.PropTypes.func.isRequired,
    close: React.PropTypes.func.isRequired,
    label: React.PropTypes.string.isRequired,
    helpPosition: React.PropTypes.oneOf(['top', 'right', 'left', 'bottom']),
    isLarge: React.PropTypes.bool,
    menuClasses: React.PropTypes.arrayOf(React.PropTypes.string),
    onOpenFunc: React.PropTypes.func,
    onCloseFunc: React.PropTypes.func
  },

  getDefaultProps: function() {
    return {
      menuClasses: [],
      helpPosition: 'bottom',
      isLarge: false
    };
  },

  toggleMenu: function() {
    if(!this.props.isOpen && this.props.onOpenFunc) {
      this.props.onOpenFunc();
    } else if(this.props.isOpen && this.props.onCloseFunc) {
      this.props.onCloseFunc();
    }

    this.props.toggleOpen();
  },

  closeMenu: function() {
    if(this.props.onCloseFunc) {
      this.props.onCloseFunc();
    }

    this.props.close();
  },

  render: function() {
    var menuCss = ['dd-menu'].concat(this.props.menuClasses).join(' ');
    var itemClasses = ['dd-menu-items'];
    if(!this.props.isOpen) {
      itemClasses.push('items-hidden');
    }

    return (
      <DropdownMenu isOpen={this.props.isOpen} forceCloseFunction={this.closeMenu}
               menuItems={this.props.children} menuClasses={this.props.menuClasses}>
         <HamburgerButton isOpen={this.props.isOpen} onBtnClick={this.toggleMenu} label={this.props.label} helpPosition={this.props.helpPosition} />
      </DropdownMenu>
    );
  }
});

module.exports = HamburgerMenu;
