import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Header.css';

export const Header = ({ userLoggedIn, setUserLoggedIn }) => {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      const token = localStorage.getItem('token'); // Retrieve token from localStorage

      // Make API call to logout endpoint with the token in the correct format
      const response = await axios.post('http://localhost:8089/logout/customer', {
        token: token
      });

      // Handle successful logout response
      if (response.data && response.data.message === "Logged out sucessfully.") {
        // Clear token from local storage
        localStorage.removeItem('token');
        // Set userLoggedIn state to false
        setUserLoggedIn(false);
        // Redirect to login page using navigate
        navigate('/login');
      } else {
        console.error('Error logging out:', response.data.message);
      }
    } catch (error) {
      console.error('Error logging out here :', error);
    }
    
    navigate('/login');
  };

  return (
    <div className="main-navbar shadow-sm sticky-top">
      <div className="top-navbar">
        <div className="container-fluid">
          <div className="row">
            <div className="col-md-2 my-auto d-none d-sm-none d-md-block d-lg-block">
              <h5 className="brand-name">QUITQ.com</h5>
            </div>
            <div className="col-md-5 my-auto">
              <form role="search">
                <div className="input-group">
                  <input type="search" placeholder="Search your product" className="form-control" />
                  <button className="btn bg-white" type="submit">
                    <i className="fa fa-search"></i>
                  </button>
                </div>
              </form>
            </div>
            <div className="col-md-5 my-auto">
              <ul className="nav justify-content-end">
                
                {/* Include the logout functionality */}
                {userLoggedIn ? (
                  <>
                  <li className="nav-item">
                    <button className="nav-link" onClick={handleLogout}>
                      <i className="fa fa-sign-out"></i> Log Out
                    </button>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="/cart">
                      <i className="fa fa-shopping-cart"></i> Cart
                    </a>
                  </li>
                  </>
                  
                ) : (
                  <>
                    <li className="nav-item">
                      <Link to="/login" className="nav-link">
                        <i className="fa fa-user"></i> Log In
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link to="/register" className="nav-link">
                        Register
                      </Link>
                    </li>
                  </>
                )}
              </ul>
            </div>
          </div>
        </div>
      </div>
      <nav className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <a className="navbar-brand d-block d-sm-block d-md-none d-lg-none" href="#">
            Funda Ecom
          </a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link to="/all-categories" className="nav-link">
                  All Categories
                </Link>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/">Home</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">New Arrivals</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/category/groceries">Groceries</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/category/electronics">Electronics</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/category/fashion">Fashions</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/category/furniture">Furniture</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/category/books">Books</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}

export default Header;
