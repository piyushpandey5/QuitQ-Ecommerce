import React, { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import { Card, Button, Toast } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import './TrendingProductList.css';

function TrendingProductList() {
  const [products, setProducts] = useState([]);
  const cardContainerRef = useRef(null);
  const [showToast, setShowToast] = useState(false);

  const storedToken = localStorage.getItem('token');
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

  const scroll = (scrollOffset) => {
    if (cardContainerRef.current) {
      cardContainerRef.current.scrollLeft += scrollOffset;
    }
  };

  const addToCart = (product) => {
    const cartItem = {
      productId: product.productId,
      productName: product.description,
      price: product.price,
      quantity: 1
    };

    axios.post('http://localhost:8089/cart/add', cartItem, {
      headers: {
        token: storedToken
      }
    })
    .then(response => {
      console.log('Product added to cart:', response.data);
      // Optionally, you can add some UI feedback here
      setShowToast(true);
    })
    .catch(error => {
      console.error('Error adding product to cart:', error);
      // Optionally, you can handle errors and provide feedback to the user
    });
  };

  return (
    <div>
      <div className="line"></div>
      <h2 className='trendingHeading'>Trending Products</h2>
      <div className="navigation-buttons">
        <Button variant="secondary" className="nav-button" onClick={() => scroll(-300)}> &lt; </Button>
        <Button variant="secondary" className="nav-button" onClick={() => scroll(300)}> &gt; </Button>
      </div>
      <div className="card-container-wrapper" ref={cardContainerRef}>
        <div className="card-container">
          {products.map(product => (
            <div className="card-item" key={product.productId}>
              <Card className="custom-card" onClick={() => console.log('Clicked on product:', product)}>
                <Link to={`/products/${product.productId}`}style={{ color: 'black', textDecoration: 'none' }}>
                  <div className="image-container">
                    <Card.Img 
                      variant="top" 
                      src={product.imageUrl}
                      alt={product.description}
                      className="card-image"
                    />
                  </div>
                </Link>
                <Card.Body className="card-body">
                  <div className="card-description">
                    <Card.Title>{product.description}</Card.Title>
                  </div>
                  <div className="card-price">
                    <p className="text-muted">Price: ${product.price}</p>
                  </div>
                  <div className="button-container">
                    <Button variant="primary" className="mr-2" onClick={() => addToCart(product)}>
                      Add to Cart
                    </Button>
                  </div>
                </Card.Body>
              </Card>
            </div>
          ))}
        </div>
      </div>
      <div className="line"></div>

      <Toast
        onClose={() => setShowToast(false)}
        show={showToast}
        delay={3000}
        autohide
        style={{
          position:'relative',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
          backgroundColor: 'green', // Change the background color to green
          color: 'white', // Change the text color to white
          minWidth: 200,
          zIndex: 9999,
          textAlign: 'center' // Center align text
        }}
      >
        <Toast.Body>Product added to cart.</Toast.Body>
      </Toast>
    </div>
  );
}

export default TrendingProductList;
