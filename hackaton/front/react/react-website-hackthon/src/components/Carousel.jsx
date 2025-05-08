import React, { useState } from 'react';

const Carousel = () => {
  const images = [
    'https://via.placeholder.com/600x300/FF0000/FFFFFF?text=Slide+1',
    'https://via.placeholder.com/600x300/00FF00/FFFFFF?text=Slide+2',
    'https://via.placeholder.com/600x300/0000FF/FFFFFF?text=Slide+3'
  ];

  const [index, setIndex] = useState(0);

  const previous = () => {
    setIndex((prevIndex) => (prevIndex - 1 + images.length) % images.length);
  };

  const next = () => {
    setIndex((prevIndex) => (prevIndex + 1) % images.length);
  };

  return (
    <div style={styles.container}>
      <button onClick={previous} style={styles.button}>◀</button>
      <img src={images[index]} alt={`Slide ${index + 1}`} style={styles.image} />
      <button onClick={next} style={styles.button}>▶</button>
    </div>
  );
};

const styles = {
  container: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    gap: '1rem',
    marginTop: '2rem',
  },
  image: {
    width: '600px',
    height: '300px',
    objectFit: 'cover',
    borderRadius: '12px',
  },
  button: {
    fontSize: '2rem',
    padding: '0.5rem 1rem',
    cursor: 'pointer',
  }
};

export default Carousel;
