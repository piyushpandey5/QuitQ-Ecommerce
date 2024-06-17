// import React, { useState } from 'react';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom'; // Import useNavigate
// import './Registeration.css';

// const Register = () => {
//   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [role, setRole] = useState('');
//   const [password, setPassword] = useState('');
//   const [successMessage, setSuccessMessage] = useState('');
//   const [errorMessage, setErrorMessage] = useState('');
//   const navigate = useNavigate(); // Initialize useNavigate

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     try {
//       const response = await axios.post('http://localhost:8089/api/authenticate/register', {
//         name,
//         email,
//         password,
//         role
//       });
//       console.log(response.data);
//       setSuccessMessage('Registration successful!');
//       setErrorMessage('');
//       // Redirect to login page upon successful registration
//       navigate('/login');
//     } catch (error) {
//       console.error('Registration failed:', error);
//       setSuccessMessage('');
//       setErrorMessage('Registration failed. Please try again.');
//       // Handle registration failure, e.g., show error message
//     }
//   };

//   return (
//     <div className="register-container">
//       <h2>Register</h2>
//       <form onSubmit={handleSubmit} className="register-form">
//         <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} required />
//         <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
//         <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
//         <select value={role} onChange={(e) => setRole(e.target.value)} required>
//           <option value="">Select Role</option>
//           <option value="SELLER">Seller</option>
//           <option value="CUSTOMER">Customer</option>
//         </select>
//         <button type="submit" className="register-button">Register</button>
//       </form>
//       {successMessage && <p className="success-message">{successMessage}</p>}
//       {errorMessage && <p className="error-message">{errorMessage}</p>}
//     </div>
//   );
// };

// export default Register;

// import React, { useState } from 'react';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';
// import { ToastContainer, toast } from 'react-toastify'; // Import ToastContainer and toast from react-toastify
// import 'react-toastify/dist/ReactToastify.css'; // Import the CSS for styling
// import "./Login.css";
// import user_icon from '../components/Assets/person.png';
// import email_icon from '../components/Assets/email.png';
// import Password_icon from '../components/Assets/password.png';
// import Phone_icon from '../components/Assets/phone.png';

// const Register = () => {
//     const [name, setName] = useState('');
//     const [email, setEmail] = useState('');
//     const [role, setRole] = useState('');
//     const [password, setPassword] = useState('');
//     const [mobileNo,setMobilNo] = useState('');
//     const navigate = useNavigate(); // Initialize useNavigate

//     const handleSubmit = async (e) => {
//         e.preventDefault();
//         try {
//             const response = await axios.post('http://localhost:8089/api/authenticate/register', {
//                 name,
//                 email,
//                 password,
//                 role
//             });
//             console.log(response.data);
//             // Show success toast
//             toast.success('Registration successful!', {
//                 onClose: () => navigate('/login') // Redirect to login page when the toast is closed
//             });
//         } catch (error) {
//             console.error('Registration failed:', error);
//             // Show error toast
//             toast.error('Registration failed. Please try again.');
//         }
//     };

//     return (
//         <div className='Container'>
//             <div className="header">
//                 <div className="text">Sign Up</div>
//                 <div className="underline"></div>
//             </div>
//             <form className='inputs' onSubmit={handleSubmit}>
//                 <div className="input">
//                     <img src={user_icon} alt="" />
//                     <input type="text" placeholder='Name' value={name} onChange={(e) => setName(e.target.value)} required />
//                 </div>
//                 <div className="input">
//                     <img src={email_icon} alt="" />
//                     <input type="email" placeholder='Email Id' value={email} onChange={(e) => setEmail(e.target.value)} required />
//                 </div>
//                 <div className="input">
//                     <img src={Phone_icon} alt="" />
//                     <input type="text" placeholder='Mobile No' value={mobileNo} onChange={(e) => setMobilNo(e.target.value)} required />
//                 </div>
//                 <div className="input">
//                     <img src={Password_icon} alt="" />
//                     <input type="password" placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)} required />
//                 </div>
                
//                 <select className='input' value={role} onChange={(e) => setRole(e.target.value)} required>
//                     <option className='input' value="">Select Role</option>
//                     <option className='input' value="SELLER">Seller</option>
//                     <option className='input' value="CUSTOMER">Customer</option>
//                 </select>
//                 <div className="submit-container">
//                     <button type="submit" className="submit">Sign Up</button>
//                 </div>
//             </form>
//             <ToastContainer /> {/* Add ToastContainer to your component */}
//         </div>
//     )
// }

// export default Register;



import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./Login.css";
import user_icon from '../components/Assets/person.png';
import email_icon from '../components/Assets/email.png';
import Password_icon from '../components/Assets/password.png';
import Phone_icon from '../components/Assets/phone.png';

const Register = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [role, setRole] = useState('');
    const [password, setPassword] = useState('');
    const [mobileNo, setMobileNo] = useState('');
    const [emailId, setEmailId] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // First request to the original endpoint
            const response1 = await axios.post('http://localhost:8089/api/authenticate/register', {
                name,
                email,
                password,
                role
            });
            console.log(response1.data);

            // Second request to the endpoint for CustomerDTO

            if(role=="CUSTOMER"){
                const response2 = await axios.post('http://localhost:8089/register/customer', {
                    email,
                    name,
                    mobileNo,
                    password
                });
                console.log(response2.data);

                toast.success('CUSTOMER Registration successful!', {
                    onClose: () => navigate('/login')
                });
            }
            else if(role == "SELLER"){
                const response2 = await axios.post('http://localhost:8089/register/seller', {
                    email,
                    name,
                    mobileNo,
                    password
                });
                console.log(response2.data);

                toast.success('SELLER Registration successful!', {
                    onClose: () => navigate('/login')
                });
            }
            
        } catch (error) {
            console.error('Registration failed:', error);
            toast.error('Registration failed. Please try again.');
        }
    };

    return (
        <div className='Container'>
            <div className="header">
                <div className="text">Sign Up</div>
                <div className="underline"></div>
            </div>
            <form className='inputs' onSubmit={handleSubmit}>
                <div className="input">
                    <img src={user_icon} alt="" />
                    <input type="text" placeholder='Name' value={name} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div className="input">
                    <img src={email_icon} alt="" />
                    <input type="email" placeholder='Email Id' value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div className="input">
                    <img src={Phone_icon} alt="" />
                    <input type="text" placeholder='Mobile No' value={mobileNo} onChange={(e) => setMobileNo(e.target.value)} required />
                </div>
                <div className="input">
                    <img src={Password_icon} alt="" />
                    <input type="password" placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                
                <select className='input' value={role} onChange={(e) => setRole(e.target.value)} required>
                    <option className='input' value="">Select Role</option>
                    <option className='input' value="SELLER">Seller</option>
                    <option className='input' value="CUSTOMER">Customer</option>
                </select>
                <div className="submit-container">
                    <button type="submit" className="submit">Sign Up</button>
                </div>
            </form>
            <ToastContainer />
        </div>
    )
}

export default Register;
