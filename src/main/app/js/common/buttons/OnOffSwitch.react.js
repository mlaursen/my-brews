
/**
 * Creates an On/Off switch. Currently, the size and colors are unconfigurable, but that
 * can be changed in the future. The label part of the button is not ideal, since it is sort of hacked
 * on the end. But it *works*
 *
 * NOTE: I couldn't figure out how to get this component to re-render when the parent's onChange function was called
 * so that is why the toggleCheckbox function sets the state.. And there is a state for this as well. Would be
 * nice to fix that in the future.
 *
 * @props isChecked boolean for defining the initial state of if the switch is on
 * @props label an optional label String to be added after the button
 * @props checkboxId a required id for the checkbox so the labels are clickable for the checkbox
 * @props onChange a function to call when the checkbox gets click
 */
var OnOffSwitch = React.createClass({
  propTypes: {
    isChecked: React.PropTypes.bool,
    label: React.PropTypes.string,
    checkboxId: React.PropTypes.string.isRequired,
    onChange: React.PropTypes.func
  },

  getInitialState: function() {
    return {
      isChecked: this.props.isChecked
    };
  },

  toggleCheckbox: function() {
    if(this.props.onChange) {
      this.props.onChange();
    }

    this.setState({
      isChecked: !this.state.isChecked
    });
  },

  render: function() {
    var label;
    if(this.props.label) {
      label = <label htmlFor={this.props.checkboxId} className="switch-label">{this.props.label}</label>
    }
    return (
      <div className="switch-button-container">
        <div className="switch-button">
          <input type="checkbox" id={this.props.checkboxId} checked={this.state.isChecked ? 'checked' : ''} onChange={this.toggleCheckbox} />
          <span className="checkbox"></span>
          <label htmlFor={this.props.checkboxId} className="switch-on">On</label>
          <label htmlFor={this.props.checkboxId} className="switch-off">Off</label>
        </div>
        {label}
      </div>
    );
  }
});

module.exports = OnOffSwitch;
