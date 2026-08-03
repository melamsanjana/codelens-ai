import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ErrorAnalyzer from "./pages/ErrorAnalyzer";
import CodeReview from "./pages/CodeReview";
import CodeFix from "./pages/CodeFix";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Login />} />

        <Route path="/register" element={<Register />} />

        <Route path="/dashboard" element={<Dashboard />} />

        <Route path="/analyzer" element={<ErrorAnalyzer />} />

        <Route path="/review" element={<CodeReview />} />

        <Route path="/fix" element={<CodeFix />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;