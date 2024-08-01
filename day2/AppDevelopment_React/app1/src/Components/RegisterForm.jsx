import React, { useState } from 'react'
import './style.css';
const RegisterForm = () => {
    const[firstname,setfirstname]=useState('');
    const[lastname,setlastname]=useState('');
    const[email,setemail]=useState('');
    const[password,setPassword]=useState('');

    const handlSubmit=(event)=>{
        event.preventDefault();
        alert(`Register with Firstname: ${firstname} and password: ${password}`);

        setfirstname('');
        setlastname('');
        setemail('');
        setPassword('');
    }

  return (
    <div>
        <h2>Register Form</h2>
        <form onSubmit={handlSubmit}>
            <div>
                <label>FIRSTNAME</label>
                <input type="text"
                value={firstname}
                onChange={(e)=>setfirstname(e.target.value)}
                required
                />
            </div>
            <div>
                <label>LASTNAME</label>
                <input type="text"
                value={lastname}
                onChange={(e)=>setlastname(e.target.value)}
                required
                />
            </div>
            <div>
                <label>EMAIL</label>
                <input type="email"
                value={email}
                onChange={(e)=>setemail(e.target.value)}
                required
                />
            </div>
            <div>
                <label>PASSWORD</label>
                <input type="password"
                value={password}
                onChange={(e)=>setPassword(e.target.value)}
                required
                />
            </div>
            <div>
                <label>CONFIRM PASSWORD</label>
                <input type="password"
                value={password}
                onChange={(e)=>setPassword(e.target.value)}
                required
                />
            </div>
            <button type="submit">Register</button>
        </form>
    </div>
  )
}

export default RegisterForm