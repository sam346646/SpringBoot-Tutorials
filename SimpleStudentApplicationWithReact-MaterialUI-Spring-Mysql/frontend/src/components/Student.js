import { React, useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button, Container, Paper } from '@mui/material';

export default function Student() {

    const paperStyle={padding:"50px 20px",width:"600px",margin:"20px auto"}
    const [name,setName] = useState();
    const [address,setAddress] = useState();

    const [studentList,setStudentList]=useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/student/all")
          .then((res) => res.json())
          .then((response) => {
            setStudentList(response)
          });
      }, []);

    const addHandle=(e) =>{
        e.preventDefault();
        const student={name,address};
        fetch("http://localhost:8080/student/add",{method:"POST",headers:{"Content-Type":"application/json"},body: JSON.stringify(student)})
        .then(()=>console.log("New student added."));
    }

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>

            <h1 style={{color:"grey"}}>Add Student</h1>

            <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 1, width: '25ch' },
                }}
                noValidate
                autoComplete="off"
            >
                <TextField value={name} onChange={(e)=>setName(e.target.value)} id="outlined-basic" label="Student Name" variant="outlined" />
                <TextField value={address} onChange={(e)=>setAddress(e.target.value)} id="outlined-basic" label="Student Address" variant="outlined" />
            </Box>
            <Button variant="contained" onClick={addHandle}>ADD</Button><br/>
            {name} {address}
            </Paper>

            <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}}>
                <h1 style={{color:"grey",textAlign:"center"}}>Students</h1> 
                {studentList.map((s)=> (
                        <Paper elevation={2} style={paperStyle} key={s.id}>
                            Id:{s.id} <br/>
                            Name:{s.name} <br/>
                            Address:{s.address}
                        </Paper>
                ))
                }
            </Paper>
        </Container>
    );
}
