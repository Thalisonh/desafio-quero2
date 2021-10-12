export type Empresa = {
    id: number,
    nome: string,
    telefone: string
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