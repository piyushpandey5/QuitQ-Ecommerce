import React from 'react';

const ExampleCarouselImage = ({ text }) => {
  return (
    <img
      className="d-block w-100"
      src={`https://www.mountaingoatsoftware.com/uploads/blog/2016-09-06-what-is-a-product.png?`}
      alt={text}
    />
  );
};

export default ExampleCarouselImage;
