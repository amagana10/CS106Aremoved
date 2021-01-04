import React from 'react';

import './UserInput.css'

const userInput = ( props ) => {
    return (
        <div className="UserInput">
            <p>UserInput component</p>
            <input onChange={props.changed} value={props.username}></input>
        </div>
    )
};

export default userInput