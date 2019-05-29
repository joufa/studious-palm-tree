export interface Team {
    id: number;
    name: string;
    updated?: Date;
    created: Date;
}

export function generateMockTeam() {
    return {
        id: 1,
        name: 'Kissalan pojat',
        created: new Date()
    };
}
