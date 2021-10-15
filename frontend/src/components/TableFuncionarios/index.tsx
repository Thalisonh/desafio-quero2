import axios from "axios";
import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { FuncionarioPage } from "../../types/funcionarios";
import PaginationFuncionario from "../PaginationFuncionario";

type Props = {
  idEmpresa: string | undefined;
}

function TableFuncionarios(idEmpresa : Props) {
  const [activePage, setActivePage] = useState(0);

  const [page, setPage] = useState<FuncionarioPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  useEffect(() => {
    axios
      .get(`https://quero2-desafio.herokuapp.com/funcionarios/empresas/${idEmpresa.idEmpresa}?page=${activePage}&size=10`)
      .then((response) => {
        setPage(response.data);
      });
  }, [activePage]);

  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <PaginationFuncionario page={page} onPageChange={changePage} />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>id</th>
            <th>Nome</th>
            <th>Cargo</th>
            <th>Salário</th>
            <th>Empresa</th>
          </tr>
        </thead>
        <tbody>
          {page.content?.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.nome}</td>
              <td>{item.cargo}</td>
              <td>R$ {item.salario}</td>
              <td>{item.nomeEmpresa}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
}

export default TableFuncionarios;
