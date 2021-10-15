import { Link } from "react-router-dom";

type Props = {
  idEmpresa: number;
};

function ButtonEnderecos(idEmpresa: Props) {
  var link = `/endereco/${idEmpresa.idEmpresa}`;
  return (
    <button type="button" className="btn btn-success">
      <Link to={link} style={{ textDecoration: 'none', color: 'white' }}>Enderecos</Link>
    </button>
  );
}
export default ButtonEnderecos;
