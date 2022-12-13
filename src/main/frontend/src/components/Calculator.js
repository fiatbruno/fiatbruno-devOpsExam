import React from "react";

class Calculator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input: "",
      result: 0,
    };
  }

  handleInput = (event) => {
    this.setState({
      input: event.target.value,
    });
  };

  calculate = () => {
    this.setState({
      result: eval(this.state.input),
    });
  };

  render() {
    return (
      <div>
        <input
          type="text"
          value={this.state.input}
          onChange={this.handleInput}
        />
        <button onClick={this.calculate}>Calculate</button>
        <p>{this.state.result}</p>
      </div>
    );
  }
}
