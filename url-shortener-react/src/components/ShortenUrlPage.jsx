import React, { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';

const ShortenUrlPage = () => {
  const { url } = useParams();

  useEffect(() => {
    if (url) {
      window.location.href = import.meta.env.VITE_BACKEND_URL + `/${url}`;
    }
  }, [url]);

  return (
    <Box 
      sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100vh' }}
    >
      <CircularProgress /> {/* Material UI loader */}
      <h2 style={{ marginTop: '20px' }}>Redirecting you to your link...</h2>
      <p>If you are not redirected, <a href={import.meta.env.VITE_BACKEND_URL + `/${url}`}>click here</a>.</p>
    </Box>
  );
};

export default ShortenUrlPage;
