var IconButton = require('./IconButton.react');
var CSSTransitionGroup = React.addons.CSSTransitionGroup;

var UnderlinedInput = React.createClass({
  propTypes: {
    inputId: React.PropTypes.string.isRequired,
    label: React.PropTypes.string.isRequired,
    onTextChange: React.PropTypes.func,
    onEnterKeypress: React.PropTypes.func,
    direction: React.PropTypes.oneOf(['left', 'center', 'right'])
  },

  getDefaultProps: function() {
    return {
      direction: 'left'
    };
  },
  
  
  getInitialState: function() {
    return {
      isButtonVisible: false,
      isActive: false
    };
  },
  
  handleFilterKeypress: function(e) {
    var key = e.which || e.keyCode;
    if(key === 27) { // Escape key
      e.preventDefault();
      this.clearFilterText(true);
      return;
    } else if(key === 13 && this.props.onEnterKeypress) {
      this.props.onEnterKeypress(e);
      return;
    }

    var val = e.target.value;
    if(this.props.onTextChange) {
      this.props.onTextChange(val);
    }

    this.setState({ isButtonVisible: val != '' });
  },

  clearFilterText: function(isFromEsc) {
    document.getElementById(this.props.inputId).value = '';
    if(this.props.onTextChange) {
      this.props.onTextChange('');
    }
    this.setState({ isButtonVisible: false, isActive: isFromEsc === true });
  },

  handleFocus: function(e) {
    this.setState({
      isActive: !this.state.isActive || document.getElementById(this.props.inputId).value !== ''
    });
  },
  
  render: function() {
    var resetBtn;
    if(this.state.isButtonVisible) {
      resetBtn = <IconButton type="reset" faIcon="times" onBtnClick={this.clearFilterText} title="Reset filter" />
    }
    var active = this.state.isActive ? 'active' : '';
    return (
      <div className={'input-underline-container from-' + this.props.direction}>
        <label className={active} htmlFor={this.props.inputId}>{this.props.label}</label>
        <input id={this.props.inputId} type="text" className={active} onKeyUp={this.handleFilterKeypress} onFocus={this.handleFocus} onBlur={this.handleFocus} />
        <span />
        <CSSTransitionGroup transitionName="grow-from-center">
          {resetBtn}
        </CSSTransitionGroup>
      </div>
    );
  }
});

module.exports = UnderlinedInput;
