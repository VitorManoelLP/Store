export class ProductModel {
  id: number;
  nome: string;
  valor: number;
  descricao: string;

  constructor(id: number, nome: string, valor: number, descricao: string) {
    (this.id = id),
      (this.nome = nome),
      (this.valor = valor),
      (this.descricao = descricao);
  }
}
