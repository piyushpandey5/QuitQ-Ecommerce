import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function Cart() {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    fetchCartItems();
  }, []);
  
  const storedToken = localStorage.getItem('token');

  const fetchCartItems = async () => {
    try {
      const response = await axios.get('http://localhost:8089/cart', {
        headers: {
          token: storedToken, // Replace 'your_token_here' with the actual token
        },
      });
      setCartItems(response.data);
    } catch (error) {
      console.error('Error fetching cart items:', error);
    }
  };

  const handleIncrement = (index) => {
    const updatedCartItems = [...cartItems];
    updatedCartItems[index].cartItemQuantity++;
    setCartItems(updatedCartItems);
  };

  const handleDecrement = (index) => {
    const updatedCartItems = [...cartItems];
    if (updatedCartItems[index].cartItemQuantity > 1) {
      updatedCartItems[index].cartItemQuantity--;
      setCartItems(updatedCartItems);
    }
  };

  const calculateTotal = () => {
    return cartItems.reduce((total, item) => total + (item.cartItemQuantity * item.cartProduct.price), 0);
  };


  return (
    <div>
      <h2 style={{ fontFamily: 'Arial, sans-serif', fontWeight: 'bold', fontSize: '50px', color: '#333', borderBottom: '2px solid #ccc', paddingBottom: '5px', marginBottom: '20px' }}>Cart Items</h2>
      <Table bordered hover style={{ marginTop: '20px', borderCollapse: 'separate', borderSpacing: '0 10px' }}>
  <thead style={{ backgroundColor: '#f5f5f5' }}>
    <tr>
      <th style={{ padding: '10px', textAlign: 'center' }}>Product Image</th>
      <th style={{ padding: '10px', textAlign: 'center' }}>Product Name</th>
      <th style={{ padding: '10px', textAlign: 'center' }}>Quantity</th>
      <th style={{ padding: '10px', textAlign: 'center' }}>Price</th>
    </tr>
  </thead>
  <tbody>
    {cartItems.map((item, index) => (
      <tr key={item.cartItemId} style={{ backgroundColor: index % 2 === 0 ? '#fff' : '#f9f9f9' }}>
        <td style={{ padding: '10px', textAlign: 'center' }}>
          <img src={item.cartProduct.imageUrl} alt="" style={{ width: '100px', height: '100px', borderRadius: '5px' }} />
        </td>
        <td style={{ padding: '10px', textAlign: 'center', verticalAlign: 'middle' }}>{item.cartProduct.productName}</td>
        <td style={{ padding: '10px', textAlign: 'center', verticalAlign: 'middle' }}>
          <Button variant="danger" size="sm" onClick={() => handleDecrement(index)}>-</Button>{' '}
          <b style={{ fontSize: '16px' }}>{item.cartItemQuantity}{' '}</b>
          <Button variant="primary" size="sm" onClick={() => handleIncrement(index)}>+</Button>
        </td>
        <td style={{ padding: '10px', textAlign: 'center', verticalAlign: 'middle' }}>${(item.cartProduct.price * item.cartItemQuantity).toFixed(2)}</td>
      </tr>
    ))}
  </tbody>
</Table>

      <Card>
        <Card.Body>
          <Card.Title>Total</Card.Title>
          <Card.Text>${calculateTotal().toFixed(2)}</Card.Text>
          <Button variant="primary" href='/address'>Checkout</Button>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Cart;
