// import React from 'react';
// import { useParams } from 'react-router-dom';
// import { Button, Card, Row, Col } from 'react-bootstrap';
// import './ProductDescription.css'; // Import custom CSS file

// function ProductDescription({ products, addToCart, buyNow }) {
//   const { productId } = useParams();
//   const productIdInt = parseInt(productId);
//   const product = products.find(product => product.productId === productIdInt);

//   if (!product) {
//     return <div className="product-description-container">Product not found</div>;
//   }

//   const handleAddToCart = () => {
//     // Check if addToCart is a function before calling it
//     if (typeof addToCart === 'function') {
//       addToCart(product);
//       alert('Product added to cart!');
//     } else {
//       console.error('addToCart is not a function');
//     }
//   };

//   const handleBuyNow = () => {
//     // Check if buyNow is a function before calling it
//     if (typeof buyNow === 'function') {
//       buyNow(product);
//       alert('Redirecting to checkout...');
//     } else {
//       console.error('buyNow is not a function');
//     }
//   };

//   return (
//     <div className="product-description-container">
//       <Card className="product-card">
//         <Row>
//           <Col xs={12} md={6} className="image-col">
//             <div className="image-container">
//               <img src={product.imageUrl} alt={product.description} className="product-image" />
//             </div>
//           </Col>
//           <Col xs={12} md={6} className="details">
//             <Card.Body className="card-body">
//               <Card.Title>{product.name}</Card.Title>
//               <Card.Text className="price">Price: ${product.price}</Card.Text>
//               <Card.Text className="description">Description: {product.description}</Card.Text>
//               <div className="button-container">
//                 <Button variant="primary" onClick={handleAddToCart}>
//                   Add to Cart
//                 </Button>
//                 <Button variant="success" onClick={handleBuyNow}>
//                   Buy Now
//                 </Button>
//               </div>
//             </Card.Body>
//           </Col>
//         </Row>
//       </Card>
//     </div>
//   );
// }

// export default ProductDescription;
import React, { useState, useEffect, useRef } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Card, Button, Toast } from 'react-bootstrap';
import './ProductDescription.css';
function ProductDescription({ products }) {
  const { productId } = useParams();
  const productIdInt = parseInt(productId);
  const product = products.find(product => product.productId === productIdInt);
  const [showToast, setShowToast] = useState(false);
  
  const storedToken = localStorage.getItem('token');
  if (!product) {
    return <div className="product-description-container">Product not found</div>;
  }
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
    <>
    <section className='pt-16 lg:pt-20 pb-12 lg:py-32 h-screen flex items-center'>
      <div className="">
        <div className="flex flex-col lg:flex-row items-center">
          <div className='flex flex-1 justify-center items-center mb-8 lg:mb-0'>
            <img className='max-w-[200px] lg:max-w-sm' src={product.imageUrl} alt="" srcSet="" style={{ boxShadow: 'rgba(0, 0, 0, 0.9) 2px 15px 38px' }} />
          </div>
          <div className='flex-1 text-center lg:text-left'>
            <br />
            <h1 className='text-[26px] font-medium mb-2 max-w-[450px] mx-auto'>{product.description}</h1>
            <div className="text-x1 text-red-500 font-medium mb-6"><span className="text-black">Price - </span>₹{product.price}</div>
            <br />
            <p className="mb-8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita minima iure quam at sed, quae ut alias unde doloribus dolor nam repellat cumque earum dolores reprehenderit perspiciatis odio iste porro rem veniam itaque adipisci, explicabo quidem. Nobis tempora odio fuga!</p>
            <button className='bg-black py-4 px-8 text-white' onClick={() => addToCart(product)} >Add to Cart</button>
          </div>
        </div>
      </div>
      
    </section>
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
    </>
      
  );
}

export default ProductDescription;
