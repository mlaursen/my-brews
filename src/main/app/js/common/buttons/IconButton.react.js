var Button = require('./Button.react');

var callback = null;

/**
 * Creates an Icon button. (A button with no borders or background).
 * If the faIcon prop is not supplied, it will attempt to render the children
 * of this component instead of creating a font-awesome icon button
 *
 * @prop btnClasses an array of additional css classes to apply to the button
 * @prop label The aria label and the help text to display for the button.
 * @prop helpPosition the position of the help text.
 * @prop faIcon the font-awesome icon name to use (without the 'fa-' prefix)
 * @prop onBtnClick The function to call when the button is clicked.
 * @children The content to render if the icon button is not a font-awesome icon button.
 */
var IconButton = React.createClass({
  propTypes: {
    btnClasses: React.PropTypes.arrayOf(React.PropTypes.string),
    label: React.PropTypes.string.isRequired,
    helpPosition: React.PropTypes.oneOf(['top', 'right', 'bottom', 'left']),
    faIcon: React.PropTypes.string,
    type: React.PropTypes.oneOf(['button', 'reset', 'submit']),
    onBtnClick: React.PropTypes.func
  },

  render: function() {
    var content = this.props.faIcon ?
      <span className={'fa fa-' + this.props.faIcon} /> :
      this.props.children;

    return (
      <Button {...this.props} btnClasses={['icon-btn'].concat(this.props.btnClasses)}>
        {content}
      </Button>
    );
  }
});

module.exports = IconButton;
