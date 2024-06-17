  // // import React, { useState } from 'react';
  // // import axios from 'axios';
  // // import { useNavigate, Link } from 'react-router-dom';
  // // import "./Login.css";

  // // const Login = ({ handleLoginSuccess }) => { // Receive handleLoginSuccess as prop
  // //   const [email, setEmail] = useState('');
  // //   const [password, setPassword] = useState('');
  // //   const [successMessage, setSuccessMessage] = useState('');
  // //   const [errorMessage, setErrorMessage] = useState('');
  // //   const navigate = useNavigate();

  // //   const handleSubmit = async (e) => {
  // //     e.preventDefault();
  // //     try {
  // //       const response = await axios.post('http://localhost:8089/api/authenticate/login', {
  // //         email,
  // //         password
  // //       });
  // //       setSuccessMessage('Login successful!');
  // //       setErrorMessage('');
  // //       if (handleLoginSuccess) { // Call handleLoginSuccess if it exists
  // //         handleLoginSuccess();
  // //       }
  // //       console.log("Token:", response.data.accessToken); // Log the token to the console
  // //       localStorage.setItem('token', response.data.accessToken); // Store the token in localStorage
  // //       navigate('/');
  // //     } catch (error) {
  // //       console.error('Login failed:', error);
  // //       setSuccessMessage('');
  // //       setErrorMessage('Login failed. Please check your credentials.');
  // //     }
  // //   };

  // //   return (
  // //     <div className="container">
  // //       <div className="row justify-content-center">
  // //         <div className="col-md-6 login-form">
  // //           <form onSubmit={handleSubmit}>
  // //             <h3>Sign In</h3>
  // //             <div className="mb-3">
  // //               <label>Email address</label>
  // //               <input className="form-control" type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
  // //             </div>
  // //             <div className="mb-3">
  // //               <label>Password</label>
  // //               <input className="form-control" type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
  // //             </div>
  // //             <div className="mb-3">
  // //               <div className="custom-control custom-checkbox">
  // //                 <input
  // //                   type="checkbox"
  // //                   className="custom-control-input"
  // //                   id="customCheck1"
  // //                 />
  // //                 <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
  // //               </div>
  // //             </div>
  // //             <div className="d-grid">
  // //               <button type="submit" className="btn btn-primary">Login</button>
  // //             </div>
  // //             <p type className="forgot-password text-right">
  // //               Forgot <a href="#">password?</a>
  // //             </p>
  // //             <p className="signup-link">Don't have an account? <Link to="/register">Sign Up</Link></p>
  // //           </form>
  // //           {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
  // //           {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
  // //         </div>
  // //       </div>
  // //     </div>
  // //   );
  // // };

  // // export default Login;


  // import React, { useState } from 'react';
  // import axios from 'axios';
  // import { useNavigate, Link } from 'react-router-dom';
  // import "./Login.css";
  // import user_icon from '../components/Assets/person.png'
  // import email_icon from '../components/Assets/email.png'
  // import Password_icon from '../components/Assets/password.png';

  // const  Login = ({ handleLoginSuccess }) => {
  //     const [email, setEmail] = useState('');
  //     const [password, setPassword] = useState('');
  //     const [successMessage, setSuccessMessage] = useState('');
  //     const [errorMessage, setErrorMessage] = useState('');
  //     const navigate = useNavigate();


  //     const handleSubmit = async (e) => {
  //     e.preventDefault();
  //     try {
  //       const response = await axios.post('http://localhost:8089/api/authenticate/login', {
  //         email,
  //         password
  //       });
  //       setSuccessMessage('Login successful!');
  //       setErrorMessage('');
  //       if (handleLoginSuccess) { // Call handleLoginSuccess if it exists
  //         handleLoginSuccess();
  //       }
  //       navigate('/');
  //       console.log("Token:", response.data.accessToken); // Log the token to the console
  //       localStorage.setItem('token', response.data.accessToken); // Store the token in localStorage
       
  //     } catch (error) {
  //       console.error('Login failed:', error);
  //       setSuccessMessage('');
  //       setErrorMessage('Login failed. Please check your credentials.');
  //     }
  //   };
  //   return(
  //     <div className='Container'>
  //       <div className="header">
  //         <div className="text">Sign In</div>
  //         <div className="underline"></div>
  //       </div>
  //       {/* <div className="inputs"> */}
  //         <form className='inputs' onSubmit={handleSubmit}>
  //           <div className="input">
  //             <img src={email_icon} alt=""/>
  //             <input type="email" placeholder='Email Id'value={email} onChange={(e) => setEmail(e.target.value)} required />
  //           </div>
  //           <div className="input">
  //             <img src={Password_icon} alt=""/>
  //             <input type="password" placeholder='Password'value={password} onChange={(e) => setPassword(e.target.value)} required />
  //           </div>
  //           <div className="submit-container">
  //             {/* <div className="submit">Sign Up</div> */}
  //             <button type = 'submit' className="submit">Login</button>
  //           </div>
  //         </form> 
  //           {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
  //           {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
  //       {/* </div> */}

  //       <div className="forgot-password">Lost Password? <span>Click Here </span></div>

        
  //     </div>
  //   )
  // }

  // export  default Login;


    // import React, { useState } from 'react';
  // import axios from 'axios';
  // import { useNavigate, Link } from 'react-router-dom';
  // import "./Login.css";

  // const Login = ({ handleLoginSuccess }) => { // Receive handleLoginSuccess as prop
  //   const [email, setEmail] = useState('');
  //   const [password, setPassword] = useState('');
  //   const [successMessage, setSuccessMessage] = useState('');
  //   const [errorMessage, setErrorMessage] = useState('');
  //   const navigate = useNavigate();

  //   const handleSubmit = async (e) => {
  //     e.preventDefault();
  //     try {
  //       const response = await axios.post('http://localhost:8089/api/authenticate/login', {
  //         email,
  //         password
  //       });
  //       setSuccessMessage('Login successful!');
  //       setErrorMessage('');
  //       if (handleLoginSuccess) { // Call handleLoginSuccess if it exists
  //         handleLoginSuccess();
  //       }
  //       console.log("Token:", response.data.accessToken); // Log the token to the console
  //       localStorage.setItem('token', response.data.accessToken); // Store the token in localStorage
  //       navigate('/');
  //     } catch (error) {
  //       console.error('Login failed:', error);
  //       setSuccessMessage('');
  //       setErrorMessage('Login failed. Please check your credentials.');
  //     }
  //   };

  //   return (
  //     <div className="container">
  //       <div className="row justify-content-center">
  //         <div className="col-md-6 login-form">
  //           <form onSubmit={handleSubmit}>
  //             <h3>Sign In</h3>
  //             <div className="mb-3">
  //               <label>Email address</label>
  //               <input className="form-control" type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
  //             </div>
  //             <div className="mb-3">
  //               <label>Password</label>
  //               <input className="form-control" type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
  //             </div>
  //             <div className="mb-3">
  //               <div className="custom-control custom-checkbox">
  //                 <input
  //                   type="checkbox"
  //                   className="custom-control-input"
  //                   id="customCheck1"
  //                 />
  //                 <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
  //               </div>
  //             </div>
  //             <div className="d-grid">
  //               <button type="submit" className="btn btn-primary">Login</button>
  //             </div>
  //             <p type className="forgot-password text-right">
  //               Forgot <a href="#">password?</a>
  //             </p>
  //             <p className="signup-link">Don't have an account? <Link to="/register">Sign Up</Link></p>
  //           </form>
  //           {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
  //           {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
  //         </div>
  //       </div>
  //     </div>
  //   );
  // };

  // export default Login;


  // import React, { useState } from 'react';
  // import axios from 'axios';
  // import { useNavigate, Link } from 'react-router-dom';
  // import "./Login.css";
  // import user_icon from '../components/Assets/person.png'
  // import email_icon from '../components/Assets/email.png'
  // import Password_icon from '../components/Assets/password.png';

  // const  Login = ({ handleLoginSuccess }) => {
  //     const [email, setEmail] = useState('');
  //     const [password, setPassword] = useState('');
  //     const [successMessage, setSuccessMessage] = useState('');
  //     const [errorMessage, setErrorMessage] = useState('');
  //     const navigate = useNavigate();
  //     // const TOKEN = "";

  //     const handleSubmit = async (e) => {
  //     e.preventDefault();
  //     try {
  //       const response = await axios.post('http://localhost:8089/login/customer', {
  //         email,
  //         password
  //       });
  //       setSuccessMessage('Login successful!');
  //       setErrorMessage('');
  //       if (handleLoginSuccess) { // Call handleLoginSuccess if it exists
  //         handleLoginSuccess();
  //       }
  //       navigate('/');
  //       console.log("Token:", response.data.token); // Log the token to the console
  //       // TOKEN = response.data.token;
  //     } catch (error) {
  //       console.error('Login failed:', error);
  //       setSuccessMessage('');
  //       setErrorMessage('Login failed. Please check your credentials.');
  //     }
  //   };
  //   return(
  //     <div className='Container'>
  //       <div className="header">
  //         <div className="text">Sign In</div>
  //         <div className="underline"></div>
  //       </div>
  //       {/* <div className="inputs"> */}
  //         <form className='inputs' onSubmit={handleSubmit}>
  //           <div className="input">
  //             <img src={email_icon} alt=""/>
  //             <input type="email" placeholder='Email Id'value={email} onChange={(e) => setEmail(e.target.value)} required />
  //           </div>
  //           <div className="input">
  //             <img src={Password_icon} alt=""/>
  //             <input type="password" placeholder='Password'value={password} onChange={(e) => setPassword(e.target.value)} required />
  //           </div>
  //           <div className="submit-container">
  //             {/* <div className="submit">Sign Up</div> */}
  //             <button type = 'submit' className="submit">Login</button>
  //           </div>
  //         </form> 
  //           {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
  //           {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
  //       {/* </div> */}

  //       <div className="forgot-password">Lost Password? <span>Click Here </span></div>

        
  //     </div>
  //   )
  // }

  // export  default Login;


import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import "./Login.css";
import user_icon from '../components/Assets/person.png'
import email_icon from '../components/Assets/email.png'
import Password_icon from '../components/Assets/password.png';

const Login = ({ handleLoginSuccess }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [role,setRole] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if(role=='CUSTOMER'){
                    const response = await axios.post('http://localhost:8089/login/customer', {
                    email,
                    password
                });
                setSuccessMessage('Login successful!');
                setErrorMessage('');
                localStorage.setItem('token', response.data.token);
                navigate('/');
            }
            else if(role=='SELLER'){
                    const response = await axios.post('http://localhost:8089/login/seller', {
                    email,
                    password
                });
                setSuccessMessage('Login successful!');
                setErrorMessage('');
                localStorage.setItem('token', response.data.token);
                navigate('/seller');
            }
            
        } catch (error) {
            console.error('Login failed:', error);
            setSuccessMessage('');
            setErrorMessage('Login failed. Please check your credentials.');
        }
    };

    return (
        <div className='Container'>
            <div className="header">
                <div className="text">Sign In</div>
                <div className="underline"></div>
            </div>
            <form className='inputs' onSubmit={handleSubmit}>
                <select className='input' value={role} onChange={(e) => setRole(e.target.value)} required>
                    <option className='input' value="">Select Role</option>
                    <option className='input' value="SELLER">Seller</option>
                    <option className='input' value="CUSTOMER">Customer</option>
                </select>
                <div className="input">
                    <img src={email_icon} alt=""/>
                    <input type="email" placeholder='Email Id' value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div className="input">
                    <img src={Password_icon} alt=""/>
                    <input type="password" placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                <div className="submit-container">
                    <button type='submit' className="submit">Login</button>
                </div>
            </form>
            {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
        </div>
    );
};

export default Login;
