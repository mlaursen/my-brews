var Router = require('react-router');
var RouteHandler = Router.RouteHandler;
var Link = Router.Link;
var CSSTransitionGroup = React.addons.CSSTransitionGroup;

var IconButton = require('./buttons/IconButton.react');
var HamburgerButton = require('./buttons/HamburgerButton.react');

var Navigation = React.createClass({
  getInitialState: function() {
    return {
      isMenuVisible: false
    };
  },

  componentDidUpdate: function(prevProps, prevState) {
    if(this.state.isMenuVisible && !prevState.isMenuVisible) {
      window.addEventListener('click', this.handleClickOutside);
    } else if(!this.state.isMenuVisible && prevState.isMenuVisble) {
      window.removeEventListener('click', this.handleClickOutside);
    }
  },

  handleClickOutside: function(e) {
    var menuBtn = React.findDOMNode(this.refs.menuBtn);
    if(e.target == menuBtn) {
      return;
    }

    var children = menuBtn.getElementsByTagName('*');
    for(var i = 0; i < children.length; i++) {
      if(children[i] == e.target) {
        return;
      } 
    }

    children = React.findDOMNode(this.refs.menu).getElementsByTagName('*');

    for(var i = 0; i < children.length; i++) {
      if(children[i] == e.target) {
        return;
      } 
    }

    this.closeMenu();
  },

  closeMenu: function() {
    this.setState({ isMenuVisible: false });
  },

  toggleMenu: function() {
    this.setState({ isMenuVisible: !this.state.isMenuVisible });
  },
  
  render: function() {
    var nav;
    if(this.state.isMenuVisible) {
      nav = (
        <div className="nav-wrapper">
          <nav className="main-nav">
            <Link to="/"><span className="fa fa-home" />Home</Link>
            <Link to="/beers"><span className="fa fa-beer" />Beers</Link>
          </nav>
        </div>
      );
    }
    return (
      <div>
        <HamburgerButton isOpen={this.state.isMenuVisible} label="Toggle Navigation Menu" onBtnClick={this.toggleMenu}  btnClasses={['main-nav-btn']} ref="menuBtn" />
        <CSSTransitionGroup transitionName="slide-nav" component="div" ref="menu">
          {nav}
        </CSSTransitionGroup>
        <section>
          <RouteHandler />
        </section>
      </div>
    );
  }
});

module.exports = Navigation;
