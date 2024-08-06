import React, { useState } from 'react'

const LoginForm = () => {
    const[email,setemail]=useState('');
    const[password,setPassword]=useState('');

    const handlSubmit=(event)=>{
        event.preventDefault();
        alert(`Login with Email: ${email} and password: ${password}`);

        setemail('');
        setPassword('');
    }

  return (
    <div>
        <h2>Login Form</h2>
        <form onSubmit={handlSubmit}>
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
            <button type="submit">Login</button>
           
        </form>
    </div>
  )
}

export default LoginForm