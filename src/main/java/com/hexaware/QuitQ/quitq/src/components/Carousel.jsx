import React, { useState, useEffect } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import './Carousel.css';

const ECarousel = ({ images }) => {
    const [index, setIndex] = useState(0);

    const handleSelect = (selectedIndex) => {
        setIndex(selectedIndex);
    };

    useEffect(() => {
        const interval = setInterval(() => {
            setIndex((prevIndex) => (prevIndex === images.length - 1 ? 0 : prevIndex + 1));
        }, 3000); // Change the interval duration as needed (e.g., 3000ms = 3 seconds)

        return () => clearInterval(interval);
    }, [images.length]);

    return (
        // <Carousel 
        //     activeIndex={index} 
        //     onSelect={handleSelect} 
        //     controls={false} // Hide the next and previous controls if needed
        //     indicators={false} // Hide the slide indicators if needed
        // >
        //     {images.map((image, idx) => (
        //         <Carousel.Item key={idx}>
        //             <img
        //                 src={image}
        //                 alt={`Slide ${idx + 1}`}
        //                 style={{ width: '500px', height: '300px' }}
        //             />
        //             <Carousel.Caption>
        //                 <h3>{`Slide ${idx + 1} label`}</h3>
        //                 <p>{`Some representative placeholder content for slide ${idx + 1}.`}</p>
        //             </Carousel.Caption>
        //         </Carousel.Item>
        //     ))}
        // </Carousel>
        <Carousel>
        <Carousel.Item>
          <img
            className="d-block mx-auto"
            src='https://assets-global.website-files.com/605826c62e8de87de744596e/6304972b0f458d536743e9d9_reebok.jpg'
            alt="First slide"
            style={{ maxWidth: '1200px', maxHeight: '600px', width: '100%', height: '600px' }}
          />
          <Carousel.Caption>
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img
                className="d-block mx-auto"
                src="https://landingi.com/wp-content/uploads/2020/05/cover_ecommerce1.webp"
                alt="Second slide"
                style={{ maxWidth: '1000px', maxHeight: '600px', width: '100%', height: '600px' }}
            />
          <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block mx-auto"
            src="https://i.imgur.com/uSMSwAx.png"
            alt="Third slide"
            style={{ maxWidth: '1200px', maxHeight: '600px', width: '100%', height: '600px' }}
          />
          <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
      
    );
};

export default ECarousel;