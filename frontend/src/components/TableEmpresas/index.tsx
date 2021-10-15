import axios from "axios";
import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { EmpresaPage } from "../../types/empresa";
import ButtonDeleteEmpresa from "../ButtonDeleteEmpresa";
import ButtonEnderecos from "../ButtonEnderecos";
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
      .get(`https://desafio-quero2.vercel.app/empresas?page=${activePage}&size=10`)
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
          </tr>
        </thead>
        <tbody>
          {page.content?.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.nome}</td>
              <td>{item.telefone}</td>
              <td>
                <ButtonFuncionarios idEmpresa={item.id} />
              </td>
              <td>
                <ButtonEnderecos idEmpresa={item.id} />
              </td>
              <td>
                <ButtonDeleteEmpresa idEmpresa={item.id} />
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
}

export default TableEmpresa;
