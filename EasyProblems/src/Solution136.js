/**
 * @param {number[]} nums
 * @return {number}
 */

var singleNumber = function(nums) {
    christlyn = new Map();
    nums.forEach( (num, index) => {
        if(!christlyn.has(num)){
            christlyn.set(num, index)
        }
        else if(christlyn.has(num)){
            christlyn.delete(num)
        }
    })
    iterator = christlyn.keys();

    return iterator.next().value;

};

console.log(singleNumber([2, 2, 1]));
