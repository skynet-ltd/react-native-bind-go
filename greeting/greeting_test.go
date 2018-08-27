package greeting

import (
	"fmt"
	"testing"
)

// TestStock ...
func TestStcok(t *testing.T) {
	val := Stock()
	if val == "" {
		t.Fail()
	}
	fmt.Println(val)
}
