// // import React, { useState, useEffect } from 'react';
// // import { Table, Button } from 'react-bootstrap';
// // import axios from 'axios';

// // const Seller = () => {
// //   const [products, setProducts] = useState([]);
// //   const[seller,setSeller] = useState([]);
// //   // Fetch products from backend
// //   useEffect(() => {
// //     fetchSeller();
// //     fetchProducts();
// //   }, []);

// //   const fetchProducts = () => {
// //     const token = localStorage.getItem('token');
// //     const config = {
// //       headers: {
// //         token: token
// //       }
// //     };
// //     axios.get(`http://localhost:8089/products/seller/1`)
// //       .then(response => {
// //         setProducts(response.data);
// //       })
// //       .catch(error => {
// //         console.error('Error fetching products:', error);
// //       });
// //   };
  
// //   const fetchSeller = () => {
// //     axios.get('http://localhost:8089/seller/current')
// //       .then(response => {
// //         setSeller(response.data);
// //         console.log("response " + response.data)
// //       })
// //       .catch(error => {
// //         console.error('Error fetching products:', error);
// //       });
// //   };

// //   const handleAddProduct = () => {
// //     // Handle adding a new product
// //     // You can implement the logic for adding a new product here
// //   };

// //   const handleRemoveProduct = (productId) => {
// //     axios.delete(`http://localhost:8089/products/${productId}`)
// //       .then(response => {
// //         if (response.status === 200) {
// //           // If deletion was successful, update the state to reflect the change
// //           setProducts(products.filter(product => product.productId !== productId));
// //         } else {
// //           console.error('Error deleting product:', response.data);
// //         }
// //       })
// //       .catch(error => {
// //         console.error('Error deleting product:', error);
// //       });
// //   };

// //   const handleEditProduct = (productId) => {
// //     // Handle editing a product
// //     // You can implement the logic for editing a product here
// //   };

// //   return (
// //     <div>
// //       <h2>Products</h2>
// //       <Table striped bordered hover>
// //         <thead>
// //           <tr>
// //             <th>Image</th>
// //             <th>Product Name</th>
// //             <th>Description</th>
// //             <th>Actions</th>
// //           </tr>
// //         </thead>
// //         <tbody>
// //           {products.map(product => (
// //             <tr key={product.productId}>
// //               <td><img src={product.imageUrl} alt={product.productName} style={{ maxWidth: '100px' }} /></td>
// //               <td>{product.productName}</td>
// //               <td>{product.description}</td>
// //               <td>
// //                 <Button variant="primary" onClick={() => handleEditProduct(product.productId)}>Edit</Button>{' '}
// //                 <Button variant="danger" onClick={() => handleRemoveProduct(product.productId)}>Remove</Button>
// //               </td>
// //             </tr>
// //           ))}
// //         </tbody>
// //       </Table>
// //       <Button variant="success" onClick={handleAddProduct}>Add Product</Button>
// //     </div>
// //   );
// // };

// // export default Seller;


// // import React, { useState, useEffect } from 'react';
// // import { Table, Button } from 'react-bootstrap';
// // import axios from 'axios';

// // const Seller = () => {
// //   const [products, setProducts] = useState([]);
// //   const [seller, setSeller] = useState([]);

// //   // Fetch products from backend
// //   useEffect(() => {
// //     fetchSeller();
// //     fetchProducts();
// //   }, []);

// //   const fetchProducts = () => {
// //     const token = localStorage.getItem('token');
// //     const config = {
// //       headers: {
// //         token: token
// //       }
// //     };
// //     axios.get(`http://localhost:8089/products/seller/1`)
// //       .then(response => {
// //         setProducts(response.data);
// //       })
// //       .catch(error => {
// //         console.error('Error fetching products:', error);
// //       });
// //   };
  
// //   const fetchSeller = () => {
// //     axios.get('http://localhost:8089/seller/current')
// //       .then(response => {
// //         setSeller(response.data);
// //         console.log("response " + response.data)
// //       })
// //       .catch(error => {
// //         console.error('Error fetching products:', error);
// //       });
// //   };

// //   const handleAddProduct = () => {
// //     // Handle adding a new product
// //     // You can implement the logic for adding a new product here
// //   };

// //   const handleRemoveProduct = (productId) => {
// //     axios.delete(`http://localhost:8089/product/${productId}`)
// //       .then(response => {
// //         if (response.status === 200) {
// //           // If deletion was successful, update the state to reflect the change
// //           setProducts(products.filter(product => product.productId !== productId));
// //         } else {
// //           console.error('Error deleting product:', response.data);
// //         }
// //       })
// //       .catch(error => {
// //         console.error('Error deleting product:', error);
// //       });
// //   };

// //   const handleEditProduct = (productId) => {
// //     // Handle editing a product
// //     // You can implement the logic for editing a product here
// //   };

// //   return (
// //     <div>
// //       <h2>Products</h2>
// //       <Table striped bordered hover>
// //         <thead>
// //           <tr>
// //             <th>Image</th>
// //             <th>Product Name</th>
// //             <th>Description</th>
// //             <th>Actions</th>
// //           </tr>
// //         </thead>
// //         <tbody>
// //           {products.map(product => (
// //             <tr key={product.productId}>
// //               <td><img src={product.imageUrl} alt={product.productName} style={{ maxWidth: '100px' }} /></td>
// //               <td>{product.productName}</td>
// //               <td>{product.description}</td>
// //               <td>
// //                 <Button variant="primary" onClick={() => handleEditProduct(product.productId)}>Edit</Button>{' '}
// //                 <Button variant="danger" onClick={() => handleRemoveProduct(product.productId)}>Remove</Button>
// //               </td>
// //             </tr>
// //           ))}
// //         </tbody>
// //       </Table>
// //       <Button variant="success" onClick={handleAddProduct}>Add Product</Button>
// //     </div>
// //   );
// // };

// // export default Seller;



// import React, { useState, useEffect } from 'react';
// import { Table, Button, Form } from 'react-bootstrap';
// import axios from 'axios';

// const Seller = () => {
//   const [products, setProducts] = useState([]);
//   const [editableProduct, setEditableProduct] = useState(null);

//   // Fetch products from backend
//   useEffect(() => {
//     fetchProducts();
//   }, []);

//   const fetchProducts = () => {
//     const token = localStorage.getItem('token');
//     const config = {
//       headers: {
//         token: token
//       }
//     };
//     axios.get(`http://localhost:8089/products/seller/1`)
//       .then(response => {
//         setProducts(response.data);
//       })
//       .catch(error => {
//         console.error('Error fetching products:', error);
//       });
//   };

//     const handleRemoveProduct = (productId) => {
//     axios.delete(`http://localhost:8089/product/${productId}`)
//       .then(response => {
//         if (response.status === 200) {
//           // If deletion was successful, update the state to reflect the change
//           setProducts(products.filter(product => product.productId !== productId));
//         } else {
//           console.error('Error deleting product:', response.data);
//         }
//       })
//       .catch(error => {
//         console.error('Error deleting product:', error);
//       });
//   };

//   const handleEditProduct = (product) => {
//     setEditableProduct(product);
//   };

//   const handleInputChange = (e) => {
//     const { name, value } = e.target;
//     setEditableProduct({
//       ...editableProduct,
//       [name]: value
//     });
//   };

//   const handleSaveProduct = () => {
//     axios.put(`http://localhost:8089/product/${editableProduct.productId}`, editableProduct)
//       .then(response => {
//         if (response.status === 200) {
//           // If update was successful, update the state to reflect the change
//           setProducts(products.map(product => {
//             if (product.productId === editableProduct.productId) {
//               console.log(product)
//               return editableProduct;
//             }
//             return product;
//           }));
//           setEditableProduct(null); // Clear the editable product after saving
//         } else {
//           console.error('Error updating product:', response.data);
//         }
//       })
//       .catch(error => {
//         console.error('Error updating product:', error);
//       });
//   };

//   return (
//     <div>
//       <h2>Products</h2>
//       <Table striped bordered hover>
//         <thead>
//           <tr>
//             <th>Image</th>
//             <th>Product Name</th>
//             <th>Description</th>
//             <th>Actions</th>
//           </tr>
//         </thead>
//         <tbody>
//           {products.map(product => (
//             <tr key={product.productId}>
//               <td><img src={product.imageUrl} alt={product.productName} style={{ maxWidth: '100px' }} /></td>
//               <td>{product.productName}</td>
//               <td>{product.description}</td>
//               <td>
//                 <Button variant="primary" onClick={() => handleEditProduct(product)}>Edit</Button>{' '}
//                 <Button variant="danger" onClick={() => handleRemoveProduct(product.productId)}>Remove</Button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </Table>
//       {editableProduct && (
//         <div>
//           <h3>Edit Product</h3>
//           <Form>
//             <Form.Group controlId="productName">
//               <Form.Label>Product Name</Form.Label>
//               <Form.Control type="text" name="productName" value={editableProduct.productName} onChange={handleInputChange} />
//             </Form.Group>
//             <Form.Group controlId="description">
//               <Form.Label>Description</Form.Label>
//               <Form.Control as="textarea" rows={3} name="description" value={editableProduct.description} onChange={handleInputChange} />
//             </Form.Group>
//             <Button variant="primary" onClick={handleSaveProduct}>Save</Button>
//           </Form>
//         </div>
//       )}
//     </div>
//   );
// };

// export default Seller;

import React, { useState, useEffect } from 'react';
import { Table, Button, Form } from 'react-bootstrap';
import axios from 'axios';

const Seller = () => {
  const [products, setProducts] = useState([]);
  const [editableProduct, setEditableProduct] = useState(null);
  const [newProduct, setNewProduct] = useState({
    productName: '',
    description: '',
    imageUrl: ''
  });
  const [showNewProductForm, setShowNewProductForm] = useState(false); // State for controlling the visibility of the form

  // Fetch products from backend
  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = () => {
    const token = localStorage.getItem('token');
    const config = {
      headers: {
        token: token
      }
    };
    axios.get(`http://localhost:8089/products/seller/1`)
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        console.error('Error fetching products:', error);
      });
  };

  const handleRemoveProduct = (productId) => {
    axios.delete(`http://localhost:8089/product/${productId}`)
      .then(response => {
        if (response.status === 200) {
          // If deletion was successful, update the state to reflect the change
          setProducts(products.filter(product => product.productId !== productId));
        } else {
          console.error('Error deleting product:', response.data);
        }
      })
      .catch(error => {
        console.error('Error deleting product:', error);
      });
  };

  const handleEditProduct = (product) => {
    setEditableProduct(product);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewProduct({
      ...newProduct,
      [name]: value
    });
  };

  const handleSaveProduct = () => {
    axios.post(`http://localhost:8089/product/1`, newProduct)
      .then(response => {
        if (response.status === 201) {
          // If creation was successful, update the state to reflect the change
          setProducts([...products, response.data]);
          setNewProduct({
            productName: '',
            description: '',
            imageUrl: ''
          });
          setShowNewProductForm(false); // Hide the form after adding a new product
        } else {
          console.error('Error adding new product:', response.data);
        }
      })
      .catch(error => {
        console.error('Error adding new product:', error);
      });
  };

  return (
    <div>
      <h2>Products</h2>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Image</th>
            <th>Product Name</th>
            <th>Description</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map(product => (
            <tr key={product.productId}>
              <td><img src={product.imageUrl} alt={product.productName} style={{ maxWidth: '100px' }} /></td>
              <td>{product.productName}</td>
              <td>{product.description}</td>
              <td>
                <Button variant="primary" onClick={() => handleEditProduct(product)}>Edit</Button>{' '}
                <Button variant="danger" onClick={() => handleRemoveProduct(product.productId)}>Remove</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      {editableProduct && (
        <div>
          <h3>Edit Product</h3>
          <Form>
            <Form.Group controlId="productName">
              <Form.Label>Product Name</Form.Label>
              <Form.Control type="text" name="productName" value={editableProduct.productName} onChange={handleInputChange} />
            </Form.Group>
            <Form.Group controlId="description">
              <Form.Label>Description</Form.Label>
              <Form.Control as="textarea" rows={3} name="description" value={editableProduct.description} onChange={handleInputChange} />
            </Form.Group>
            <Button variant="primary" onClick={handleSaveProduct}>Save</Button>
          </Form>
        </div>
      )}
      {showNewProductForm && (
        <div>
          <h3>Add New Product</h3>
          <Form>
            <Form.Group controlId="newProductName">
              <Form.Label>Product Name</Form.Label>
              <Form.Control type="text" name="productName" value={newProduct.productName} onChange={handleInputChange} />
            </Form.Group>
            <Form.Group controlId="newDescription">
              <Form.Label>Description</Form.Label>
              <Form.Control as="textarea" rows={3} name="description" value={newProduct.description} onChange={handleInputChange} />
            </Form.Group>
            <Form.Group controlId="newImageUrl">
              <Form.Label>Image URL</Form.Label>
              <Form.Control type="text" name="imageUrl" value={newProduct.imageUrl} onChange={handleInputChange} />
            </Form.Group>
            <Button variant="success" onClick={handleSaveProduct}>Add Product</Button>
          </Form>
        </div>
      )}
      {!showNewProductForm && (
        <Button variant="info" onClick={() => setShowNewProductForm(true)}>Add New</Button>
      )}
    </div>
  );
};

export default Seller;
