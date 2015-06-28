var CSSTransitionGroup = React.addons.CSSTransitionGroup;

/**
 * Common functionality for creating a dropdown menu. Some things that get automatically
 * added are when the menu is open it will be closed if somewhere else on the
 * screen has been clicked.
 *
 * In addition, keyboard accessibility has been added so that the items can
 * correctly be tabbed through and closed. Might need to update it a tiny bit
 * to allow tab indexes.
 *
 * Some features for the future might be allowing the transition name to change.
 *
 * @prop isOpen boolean if the dropdown menu is currently open
 * @prop forceCloseFunction the function to call to force the menu to close
 * @prop menuItems a renderable item to be in the menu. This 'should' be a ul, or ol of li's
 * @prop menuClasses a list of aoptional classes to add the the entire dropdown menu
 * @children The content to display before the menu (this is usually text or a button to trigger the menu open)
 */
var DropdownMenu = React.createClass({
  propTypes: {
    isOpen: React.PropTypes.bool.isRequired,
    forceCloseFunction: React.PropTypes.func.isRequired,
    menuItems: React.PropTypes.node.isRequired,
    menuClasses: React.PropTypes.arrayOf(React.PropTypes.string)
  },
  
  getDefaultProps: function() {
    return {
      menuClasses: []
    };
  },

  /* Only have the click events enabled when the menu is open */
  componentDidUpdate: function(prevProps, prevState) {
    if(this.props.isOpen && !prevProps.isOpen) {
      window.addEventListener('click', this.handleClickOutside);
    } else if(!this.props.isOpen && prevProps.isOpen) {
      window.removeEventListener('click', this.handleClickOutside);
    }
  },

  /* If clicked element is not in the dropdown menu children, close menu */
  handleClickOutside: function(e) {
    var children = this.getDOMNode().getElementsByTagName('*');
    for(var i = 0; i < children.length; i++) {
      if(children[i] == e.target) {
        return;
      } 
    }

    this.props.forceCloseFunction(e);
  },

  handleKeyDown: function(e) {
    var key = e.which || e.keyCode;
    if(key !== 9) { // tab
      return;
    }

    var items = this.getDOMNode().querySelectorAll('button,a');
    if(e.target == items[items.length - 1]) {
      this.props.forceCloseFunction(e);
    }
  },
  
  render: function() {
    var items, hiddenToggle;
    if(this.props.isOpen) {
      items = this.props.menuItems;
    }
    var menuClasses = ['dd-menu'].concat(this.props.menuClasses);

    return (
      <div className={menuClasses.join(' ')}>
        {this.props.children}
        <CSSTransitionGroup transitionName="grow-from-right" component="div" className="dd-menu-items" onKeyDown={this.handleKeyDown}>
          {items}
        </CSSTransitionGroup>
      </div>
    );
  }
});

module.exports = DropdownMenu;
