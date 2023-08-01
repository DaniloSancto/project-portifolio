import "./styles.css";

const Navbar = () => {
  return (
    <div className="nav-container">
      <div className="nav-content">
        <div className="nav-logo">
          <a href="/">
            <h1 className="logo-text">PORTIFÓLIO</h1>
          </a>
        </div>
        <div className="nav-links">
          <a href="/">
            <p className="link-text">LOGIN</p>
          </a>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
