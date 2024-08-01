import { useState } from 'react';
import './App.css';
import LoginForm from './Components/LoginForm';
import RegisterForm from './Components/RegisterForm';

function App() {
  const [isReg, setIsReg] = useState(true);

  return (
    <div className="App">
      {isReg ? <RegisterForm /> : <LoginForm />}
      <div className="switch-container" onClick={() => setIsReg(!isReg)}>
        <span className="switch-text">
          {isReg ? 'Already have an account? Login' : 'Don\'t have an account? Register'}
        </span>
        <span className="switch-instruction">(Click Here!)</span>
      </div>
    </div>
  );
}

export default App;