import React, { useState } from 'react';
import { Container, Row, Col, Form, Button, Toast } from 'react-bootstrap';
import axios from 'axios';

const AddressForm = () => {
  const [streetNo, setStreetNo] = useState('');
  const [buildingName, setBuildingName] = useState('');
  const [locality, setLocality] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [pincode, setPincode] = useState('');
  const [type, setType] = useState('home');
  const [showToast, setShowToast] = useState(false);
  const storedToken = localStorage.getItem('token');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const addressData = {
      streetNo,
      buildingName,
      locality,
      city,
      state,
      pincode
    };

    try {
      const response = await axios.put(`http://localhost:8089/customer/update/address?type=${type}`, addressData, {
        headers: {
          'Content-Type': 'application/json',
          'token': storedToken
        }
      });
      console.log('Address updated:', response.data);
      setShowToast(true);
      clearForm();
      clearCart();
    } catch (error) {
      console.error('Error updating address:', error);
    }
  };

  const clearCart = async () => {
    try {
      await axios.delete('http://localhost:8089/cart/clear', {
        headers: {
          'token': storedToken
        }
      });
      console.log('Cart cleared');
    } catch (error) {
      console.error('Error clearing cart:', error);
    }
  };

  const clearForm = () => {
    setStreetNo('');
    setBuildingName('');
    setLocality('');
    setCity('');
    setState('');
    setPincode('');
    setType('home');
  };

  return (
    <Container className="mt-5 mb-5">
      <Row>
        <Col>
          <h1 className="text-center mb-4">Address</h1>
        </Col>
      </Row>

      <Row>
        <Col lg={8} className="mx-auto">
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="streetNo">
              <Form.Label>Street Number</Form.Label>
              <Form.Control type="text" placeholder="Enter street number" value={streetNo} onChange={(e) => setStreetNo(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="buildingName">
              <Form.Label>Building Name</Form.Label>
              <Form.Control type="text" placeholder="Enter building name" value={buildingName} onChange={(e) => setBuildingName(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="locality">
              <Form.Label>Locality</Form.Label>
              <Form.Control type="text" placeholder="Enter locality" value={locality} onChange={(e) => setLocality(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="city">
              <Form.Label>City</Form.Label>
              <Form.Control type="text" placeholder="Enter city" value={city} onChange={(e) => setCity(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="state">
              <Form.Label>State</Form.Label>
              <Form.Control type="text" placeholder="Enter state" value={state} onChange={(e) => setState(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="pincode">
              <Form.Label>Pincode</Form.Label>
              <Form.Control type="text" placeholder="Enter pincode" value={pincode} onChange={(e) => setPincode(e.target.value)} />
            </Form.Group>

            <Form.Group controlId="type">
              <Form.Label>Type</Form.Label>
              <Form.Control as="select" value={type} onChange={(e) => setType(e.target.value)}>
                <option value="home">Home</option>
                <option value="office">Office</option>
              </Form.Control>
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100 mt-3">
                Place Order
            </Button>
          </Form>
        </Col>
      </Row>

      <Toast show={showToast} onClose={() => setShowToast(false)} delay={3000} autohide className="mt-3">
        <Toast.Header>
          <strong className="mr-auto">Success</strong>
        </Toast.Header>
        <Toast.Body>Order Placed successfully!</Toast.Body>
      </Toast>

    </Container>
  );
};

export default AddressForm;
