export type Empresa = {
    id: number,
    nome: string,
    telefone: string,
    endereco : {
        logradouro: string,
        localidade: string,
        numero: number,
        uf: string,
        cep: string,
    }
}

export type EmpresaPage = {
    content?: Empresa[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    first: boolean;
    size?: number;
    number: number;
    numberOfElements?: number;
    empty?: boolean;
}