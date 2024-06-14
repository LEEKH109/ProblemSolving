const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const n = parseInt(input[0]);
    let meetings = [];
    for (let i = 1; i <= n; i++) {
        const [start, end] = input[i].split(' ').map(Number);
        meetings.push({ start, end });
    }

    // 정렬 로직: 종료 시간 기준, 종료 시간이 같다면 시작 시간 기준으로 정렬
    meetings.sort((a, b) => {
        if (a.end === b.end) {
            return a.start - b.start;
        }
        return a.end - b.end;
    });

    let maxMeetings = getMaxMeetings(meetings);
    console.log(maxMeetings);

    process.exit();
});

function getMaxMeetings(meetings) {
    let lastEndTime = 0;
    let count = 0;
    for (let meeting of meetings) {
        if (meeting.start >= lastEndTime) {
            lastEndTime = meeting.end;
            count++;
        }
    }
    return count;
}