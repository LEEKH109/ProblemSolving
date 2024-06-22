class Node {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}

class Queue {
    constructor() {
        this.head = null;
        this.tail = null;
    }
    
    enqueue(value) {
        const newNode = new Node(value);
        if (this.tail) {
            this.tail.next = newNode;
        } else {
            this.head = newNode;
        }
        this.tail = newNode;
    }
    
    dequeue() {
        if (!this.head) return null;
        const value = this.head.value;
        this.head = this.head.next;
        if (!this.head) this.tail = null;
        return value;
    }
    
    isEmpty() {
        return this.head === null;
    }
}

function solution(maps) {
    const n = maps.length;
    const m = maps[0].length;
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];  // 동, 남, 서, 북
    const queue = new Queue();
    queue.enqueue([0, 0, 1]);  // [x, y, distance]
    const visited = Array.from(Array(n), () => Array(m).fill(false));
    visited[0][0] = true;
    
    while (!queue.isEmpty()) {
        const [x, y, distance] = queue.dequeue();
        // 목표 지점에 도달하면 거리 반환
        if (x === n - 1 && y === m - 1) {
            return distance;
        }
        for (const [dx, dy] of directions) {
            const nx = x + dx;
            const ny = y + dy;
            // 유효한 좌표인지, 방문한 적이 없는지, 벽이 아닌지 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] === 1) {
                visited[nx][ny] = true;
                queue.enqueue([nx, ny, distance + 1]);
            }
        }
    }
    // 목표 지점에 도달할 수 없는 경우
    return -1;
}