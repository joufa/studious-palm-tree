export interface Team {
  teamId: number;
  name: string;
  memberCount: number;
  description: string;
  updatedAt?: Date;
  createdAt?: Date;
}

export interface TeamDTO {
  operation?: TeamOperationType;
  teamId?: number;
  name: string;
  memberCount?: number;
  description?: string;
  updatedAt?: Date;
  createdAt?: Date;
}
export enum TeamOperationType {
  CREATE,
  UPDATE,
  DELETE
}
export function generateMockTeam() {
  return {
    id: 1,
    name: 'Kissalan pojat',
    created: new Date()
  };
}
