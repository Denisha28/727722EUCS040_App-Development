// src/PaymentForm.js
import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import './PaymentForm.css';

const PaymentForm = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { plan, name, email } = location.state || {}; // Extract state from location

  const [cardNumber, setCardNumber] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [cvv, setCvv] = useState('');
  const [nameOnCard, setNameOnCard] = useState('');
  const [pass, setPass] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false); // Loading state

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate card number length
    if (cardNumber.length !== 16) {
      setError('Card number must be exactly 16 digits.');
      return;
    }

    setLoading(true); // Set loading to true when starting payment processing

    // Simulate payment processing
    setTimeout(() => {
      setLoading(false); // Set loading to false after payment processing
      navigate('/receipt', {
        state: { plan, name, email, cardNumber, expiryDate, cvv, nameOnCard }
      });
    }, 2000);
  };

  return (
    <div className="payment-form">
      <h2>Payment Form</h2>
      {loading ? (
        <p className="loading-message">Processing payment, please wait...</p>
      ) : (
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="cardNumber">Card Number:</label>
            <input
              type="text"
              id="cardNumber"
              value={cardNumber}
              onChange={(e) => setCardNumber(e.target.value.replace(/\D/g, ''))}
              required
              maxLength="16"
              placeholder="Enter 16-digit card number"
            />
          </div>
          <div className="form-group">
            <label htmlFor="expiryDate">Expiry Date:</label>
            <input
              type="text"
              id="expiryDate"
              value={expiryDate}
              onChange={(e) => setExpiryDate(e.target.value)}
              required
              placeholder="MM/YY"
            />
          </div>
          <div className="form-group">
            <label htmlFor="cvv">CVV:</label>
            <input
              type="password"
              id="cvv"
              value={cvv}
              onChange={(e) => setCvv(e.target.value.replace(/\D/g, ''))}
              required
              maxLength="3"
              placeholder="CVV"
            />
          </div>
          <div className="form-group">
            <label htmlFor="nameOnCard">Name on Card:</label>
            <input
              type="text"
              id="nameOnCard"
              value={nameOnCard}
              onChange={(e) => setNameOnCard(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="pass">Password:</label>
            <input
              type="password"
              id="pass"
              value={pass}
              onChange={(e) => setPass(e.target.value)}
              required
            />
          </div>
          {error && <p className="error-message">{error}</p>}
          <button type="submit" className="cta-button">Pay Now</button>
        </form>
      )}
    </div>
  );
};

export default PaymentForm;
