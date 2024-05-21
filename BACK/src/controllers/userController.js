import userModel from "../models/userModel";
import bcrypt from 'bcryptjs';

export const signupUser = async (req, res) => {
    try {
        const { username, email, password } = req.body;
        if(!(username && email && password)) {
            return res.status(400).json({ error: 'Username, password, and email are required' });
        }

        const existingUser = await userModel.findOne({ $or: [{ username }, { email }] });
        if (existingUser) {
            return res.status(409).json({ error: 'User already exists' });
        }


        const hashedPassword = await bcrypt.hash(password, 10);

        const newUser = new userModel({
            username,
            password: hashedPassword,
            email
        });

        await newUser.save();

        const userForResponse = { ...newUser.toObject() };
        delete userForResponse.password;
        res.status(201).json(userForResponse);
    } catch (error) {
        res.status(500).json({ error: 'Internal Server Error', details: error })
    }
};

export const loginUser = async (req, res, next) => {
    console.log('logging in');
    passport.authenticate('local', (err, user, info) => {
      if (err) return next(err);
      if (!user) {
        return res.status(400).json({ message: info.message });
      }
      req.logIn(user, (err) => {
        if (err) return next(err);
        return res.status(200).json({ message: 'Logged in successfully' });
      });
    })(req, res, next);
  };