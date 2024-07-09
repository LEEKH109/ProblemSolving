class Path {
    constructor(x, y, path, remainingDistance) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.remainingDistance = remainingDistance;
    }
}

function solution(n, m, x, y, r, c, k) {
    const dx = [-1, 0, 0, 1]; // 상, 우, 좌, 하
    const dy = [0, 1, -1, 0];
    const dirChars = ['u', 'r', 'l', 'd']; // 해당 방향을 문자로 매핑

    if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 !== 0) {
        return "impossible";
    }

    const stack = [new Path(x, y, "", k)];

    while (stack.length > 0) {
        const current = stack.pop();

        if (current.remainingDistance === 0) {
            if (current.x === r && current.y === c) {
                return current.path;
            }
            continue;
        }

        for (let i = 0; i < 4; i++) {
            const nx = current.x + dx[i];
            const ny = current.y + dy[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                const newPath = current.path + dirChars[i];
                const newRemaining = current.remainingDistance - 1;
                const manhattan = Math.abs(r - nx) + Math.abs(c - ny);
                if (manhattan <= newRemaining && (newRemaining - manhattan) % 2 === 0) {
                    stack.push(new Path(nx, ny, newPath, newRemaining));
                }
            }
        }
    }

    return "impossible";
}