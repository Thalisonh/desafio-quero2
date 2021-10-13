import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { EmpresaPage } from "../../types/empresa";
import ButtonFuncionarios from "../ButtonFuncionarios";
import PaginationEmpresa from "../PaginationEmpresa";

function TableEmpresa() {
  const [activePage, setActivePage] = useState(0);

  const [page, setPage] = useState<EmpresaPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  useEffect(() => {
    axios
      .get(`http://localhost:8080/empresas?page=${activePage}&size=10`)
      .then((response) => {
        setPage(response.data);
      });
  }, [activePage]);

  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <PaginationEmpresa page={page} onPageChange={changePage} />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Visualizar</th>
          </tr>
        </thead>
        <tbody>
          {page.content?.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.nome}</td>
              <td>{item.telefone}</td>
              <td><ButtonFuncionarios idEmpresa={item.id}/></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
}

export default TableEmpresa;
