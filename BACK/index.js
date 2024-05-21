const express = require('express');
const bodyParser = require('body-parser');
const connectDB = require('./src/config/db.js');
const authRoutes = require('./src/routes/auth.js');
const dotenv = require('dotenv');

dotenv.config();

const app = express();

// Connect to Database
connectDB();

// Middleware
app.use(bodyParser.json());

// Routes
app.use('/api/auth', authRoutes);

// Start Server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
