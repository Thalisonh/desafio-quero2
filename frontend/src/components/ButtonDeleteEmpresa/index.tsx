import axios from "axios";

type Props = {
  idEmpresa: number;
};

function ButtonDeleteEmpresa(idEmpresa: Props) {
    const submitForm = (event: React.FormEvent<HTMLFormElement>) => {
        axios
          .delete(`http://localhost:8080/empresas/${idEmpresa.idEmpresa}`)
          .then((res) => {
            console.log(res);
            console.log(res.data);
          });
      }

  return (
    <form onSubmit={submitForm}>
    <button type="submit" className="btn btn-danger">Deletar</button>
    </form>
  );
}
export default ButtonDeleteEmpresa;
