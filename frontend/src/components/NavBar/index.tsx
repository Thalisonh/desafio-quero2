import { Link } from 'react-router-dom';

function NavBar() {
    return (
        <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-light border-bottom shadow-sm" >
            <div className="container">
                <nav className="my-2 my-md-0 mr-md-3">
                    <Link to="/">
                        <h1>Home</h1>
                    </Link>
                    <Link to="/cadastrar">
                        <h1>Nova Empresa</h1>
                    </Link>
                </nav>
            </div>
        </div >
    );
}

export default NavBar;