import { Link } from "react-router-dom"

type Props = {
    idEmpresa: number;
}

function ButtonFuncionarios(idEmpresa : Props){
    var link = `/empresa/${idEmpresa.idEmpresa}`
    return(
        
        <button type="button" className="btn btn-success">
        <Link to={link}>
            Visualizar
        </Link>
    </button>
    )
}
export default ButtonFuncionarios