// src/TournamentRegistration.js
import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import './TournamentRegistration.css';

const TournamentRegistration = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const { tournament, tournamentId, location: tournamentLocation, date: tournamentDate } = state || {};

  const [playerName, setPlayerName] = useState('');
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');

  const [formTournamentId, setFormTournamentId] = useState(tournamentId || '');
  const [formTournamentName, setFormTournamentName] = useState(tournament || '');
  const [formLocation, setFormLocation] = useState(tournamentLocation || '');
  const [formDate, setFormDate] = useState(tournamentDate || '');

  useEffect(() => {
    setFormTournamentId(tournamentId || '');
    setFormTournamentName(tournament || '');
    setFormLocation(tournamentLocation || '');
    setFormDate(tournamentDate || '');
  }, [tournamentId, tournament, tournamentLocation, tournamentDate]);

  const handleRegister = (e) => {
    e.preventDefault();
    if (formTournamentId && formTournamentName && playerName && email && formLocation && formDate) {
      // Simulate successful registration and navigate to tournament details
      navigate('/tournament-details', { state: { tournamentId: formTournamentId, tournamentName: formTournamentName, playerName, email, location: formLocation, date: formDate } });
    } else {
      setError('Please fill in all fields');
    }
  };

  return (
    <div className="registration-container">
      <h2>Register for {formTournamentName || 'Tournament'}</h2>
      <form className="registration-form" onSubmit={handleRegister}>
        <div className="form-group">
          <label htmlFor="tournamentId">Tournament ID:</label>
          <input
            type="text"
            id="tournamentId"
            value={formTournamentId}
            onChange={(e) => setFormTournamentId(e.target.value)}
            readOnly
          />
        </div>
        <div className="form-group">
          <label htmlFor="tournamentName">Tournament Name:</label>
          <input
            type="text"
            id="tournamentName"
            value={formTournamentName}
            onChange={(e) => setFormTournamentName(e.target.value)}
            readOnly
          />
        </div>
        <div className="form-group">
          <label htmlFor="playerName">Player Name:</label>
          <input
            type="text"
            id="playerName"
            value={playerName}
            onChange={(e) => setPlayerName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="location">Location:</label>
          <input
            type="text"
            id="location"
            value={formLocation}
            onChange={(e) => setFormLocation(e.target.value)}
            readOnly
          />
        </div>
        <div className="form-group">
          <label htmlFor="date">Date:</label>
          <input
            type="date"
            id="date"
            value={formDate}
            onChange={(e) => setFormDate(e.target.value)}
            readOnly
          />
        </div>
        <button type="submit" className="cta-button">Register</button>
        {error && <p className="error-message">{error}</p>}
      </form>
    </div>
  );
};

export default TournamentRegistration;
