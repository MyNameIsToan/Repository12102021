export class Notes {
  id!: bigint;
  parentid !: bigint;
  content !: string;
  username !: string;
  haschild !: number;
  isfinish !: number;
}
