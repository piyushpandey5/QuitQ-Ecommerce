
import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import BrowserRouter and Routes
import { Header } from './components/Header';
import Carousel from './components/Carousel';
import Footer from './components/Footer/Footer';
import Login from './components/Login';
import Register from './components/RegistrationPage';
import img3 from './components/images/img3.png';
import Cart from './components/Cart';
import ProductList from './components/ProductList';
import TrendingProductList from './components/TrendingProductList';
import ProductDescription from './components/ProductDescription';
import CategoryProductList from './components/CategoryProductList';
import Seller from './components/Seller';
import AddressForm from './components/Address';
import OrderPlaced from './components/OrderPlaced'
function App() {
  const [products, setProducts] = useState([]);
  const productImages = [img3, img3, img3];
  const [userLoggedIn, setUserLoggedIn] = useState(true);

  useEffect(() => {
    axios.get('http://localhost:8089/products')
      .then(response => {
        setProducts(response.data);
        console.log('Products fetched successfully:', response.data);

      })
      .catch(error => {
        console.error('Error fetching products:', error);
      });
  }, []);

  useEffect(() => {
    axios.get('http://localhost:8089/products')
      .then(response => {
        setProducts(response.data);
        console.log('Products fetched successfully:', response.data);

      })
      .catch(error => {
        console.error('Error fetching products:', error);
      });
  }, []);

  
  
  return (
    <Router>
      <div className="App">
      <Header userLoggedIn={userLoggedIn} setUserLoggedIn={setUserLoggedIn} />
        <div className="main-content"> {/* Use main-content class for the main content area */}
          <Routes>
            <Route path="/" element={<Home productImages={productImages} />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/cart" element={<Cart />} />
            <Route path="/products/:productId" element={<ProductDescription products={products} />} />
            <Route path="/category/:category" element={<CategoryProductList />} />
            <Route path = "/seller" element = {<Seller/>}/>
            <Route path = "/address" element = {<AddressForm/>}/>
            <Route path = "/ordered" element = {<OrderPlaced/>}/>
          </Routes>
        </div>
        <Footer />
      </div>
    </Router>
  );
}

// Define a separate component for the home page
function Home({ productImages }) {
  return (
    <div>
      <Carousel images={productImages} />
      <ProductList />
      <TrendingProductList />
    </div>
  );
}

export default App;
