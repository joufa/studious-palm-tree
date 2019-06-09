export interface Team {
    teamId: number;
    name: string;
    memberCount: number;
    description: string;
    updatedAt?: Date;
    createdAt?: Date;
}

export interface TeamDTO {
    teamId?: number;
    name: string;
    memberCount?: number;
    description?: string;
    updatedAt?: Date;
    createdAt?: Date;
}

export function generateMockTeam() {
    return {
        id: 1,
        name: 'Kissalan pojat',
        created: new Date()
    };
}
