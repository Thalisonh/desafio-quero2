import { Container } from "react-bootstrap";
import NavBar from "../../components/NavBar";
import TableEmpresa from "../../components/TableEmpresas";

function Home() {
  return (
    <>
      <Container>
        <NavBar />
        <TableEmpresa />
      </Container>
    </>
  );
}

export default Home;
